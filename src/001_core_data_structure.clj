(ns core-data-structure)

;; --- DEFINITION ---

;; List: Ordered, like (1 2 3), used for function calls
(list 3 2 1)
'(1 2 3)

;; Vector: Ordered, indexed
[1 2 3]

;; Map: Key-value store
{:name "Sav" :level 2}

;; Set: Unique elements
#{:a :b :c}

;; --- DATA MANIPULATION ---

(conj [1 2] 3) ; [1 2 3]
(assoc {:a 1} :b 2) ; {:a 1, :b 2}
(dissoc {:a 1 :b 2} :b) ; {:a 1}
(merge {:a 1} {:b 2}) ; {:a 1, :b 2}

(def adventurer {:name "Sav" :hp 100 :inventory ["Magic Wand" "Potion"]})
(get adventurer :name)
(update adventurer :hp dec)
(get adventurer :hp)

;; --- CONTROL FLOW ---

;; If/Else
(def age 25)
(if (> age 18)
  "You are allowed to drink!"
  "You're not an adult yet!")

;; Cond (like switch/case)
(def age2 18)
(cond
  (< age2 18) "Too young"
  (= age2 18) "Just right"
  :else "An adult!")

;; --- FUNCTION ---
(def hero {:name "Sav" :inventory ["wand"] :hp 90})
(defn add-item
  "Adds item to inventory"
  [character item]
  (update character :inventory conj item)
;; shorthand for:   (assoc character :inventory (conj (get character :inventory) item))
  )
(add-item hero "elixir")

(defn check-health [hp]
  (cond
    (>= hp 80) "I feel great!"
    (>= hp 50) "I'm okay"
    :else "I need healing!"
    ))
(check-health (hero :hp))