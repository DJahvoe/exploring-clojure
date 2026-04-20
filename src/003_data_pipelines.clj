(ns data-pipelines
  (:require [clojure.string :as str]))

;; --- Level 3: Data Pipelines & Lazy Sequences ---
;; Evaluate forms with your REPL to explore how Clojure
;; transforms data step by step.

(def quests
  [{:title "Wake the Forest Guardian"
    :difficulty :hard
    :completed? true
    :xp 120
    :loot ["oak staff" "moss cloak"]}
   {:title "Refill the Moon Well"
    :difficulty :medium
    :completed? false
    :xp 70
    :loot ["moon water"]}
   {:title "Map the Crystal Cavern"
    :difficulty :hard
    :completed? true
    :xp 200
    :loot ["crystal shard" "bat wing"]}
   {:title "Escort the Merchant"
    :difficulty :easy
    :completed? true
    :xp 40
    :loot []}])

;; == 1. Threading Data Through a Pipeline ==

(->> quests
     (filter :completed?)
     (map :xp)
     (reduce +))
;; => 360

(defn completed-xp
  "Total XP from completed quests."
  [quest-log]
  (->> quest-log
       (filter :completed?)
       (map :xp)
       (reduce + 0)))

(completed-xp quests)

;; Thread-first (->) is often handy for map updates.
(-> {:name "Sav" :hp 12 :status #{:poisoned}}
    (update :hp + 8)
    (update :status disj :poisoned)
    (assoc :rested? true))

;; == 2. Summaries from Nested Data ==

(defn loot-report
  [quest-log]
  (->> quest-log
       (mapcat :loot)
       (remove str/blank?)
       sort
       vec))

(loot-report quests)
;; => ["bat wing" "crystal shard" "moss cloak" "moon water" "oak staff"]

(defn quest-summary
  [quest-log]
  {:completed (count (filter :completed? quest-log))
   :remaining (count (remove :completed? quest-log))
   :by-difficulty (frequencies (map :difficulty quest-log))})

(quest-summary quests)

;; == 3. Grouping ==

(group-by :difficulty quests)

(defn completed-titles-by-difficulty
  [quest-log]
  (->> quest-log
       (filter :completed?)
       (group-by :difficulty)
       (reduce-kv (fn [result difficulty qs]
                    (assoc result difficulty (mapv :title qs)))
                  {})))

(completed-titles-by-difficulty quests)

;; == 4. Laziness ==

;; `iterate` creates an infinite lazy sequence.
(def energy-orbs
  (iterate #(+ % 3) 1))

(take 8 energy-orbs)
;; => (1 4 7 10 13 16 19 22)

(->> energy-orbs
     (filter odd?)
     (take 5))
;; => (1 7 13 19 25)

;; `repeatedly` is also lazy.
(def random-encounters
  (repeatedly #(rand-nth ["slime" "goblin" "wisp" "mimic"])))

(take 6 random-encounters)

;; == 5. A More "Clojure" Feeling Example ==

(defn next-three-hard-quest-rewards
  [quest-log]
  (->> quest-log
       (filter #(= :hard (:difficulty %)))
       (mapcat :loot)
       (take 3)
       (str/join ", ")))

(next-three-hard-quest-rewards quests)

;; Mini-quests:
;; 1. Change `completed-xp` so hard quests grant double XP.
;; 2. Use `sort-by` to order quests by `:xp`.
;; 3. Use `cycle` together with `take` to create a repeating turn order.

"Level 3 complete!"
