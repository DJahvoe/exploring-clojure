(ns get-started.basic)

(let [x 3] x)

(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])
(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)

(let [[pongo & dalmatians] dalmatian-list] 
  [pongo dalmatians])

(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3) 
    (println "Goodbye!")
    (recur (inc iteration))))

(defn recursive-printer
  ([] (recursive-printer 0))
  ([iteration]
   (println iteration)
   (if (> iteration 3)
     (println "Goodbye!")
     (recursive-printer (inc iteration)))))
(recursive-printer)


(def test [1 2 3 4 5 6 7])
(loop [experiment test
       result []]
  (if (empty? experiment) result 
      (let [[part & remaining] experiment] 
        (recur remaining
               (into result 
                     (set (if (even? part) [part] [])))))))
  

(take 2 (iterate inc 5))