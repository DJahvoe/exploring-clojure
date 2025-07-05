(ns functionalist)

;; --- Level 3: The Functionalist — Power of Functions & Recursion ---
;; Inspired by Clojure for the Brave and True, Chapter 3
;;
;; Evaluate forms with your REPL to explore each concept.

;; == 1. Function Definitions ==

(defn greet [name]
  (str "Hello, " name "!"))

;; Try evaluating:
;; (greet "Sav")

;; == 2. Anonymous Functions ==

;; Full form:
(fn [x] (* x 2))

;; Shorthand form:
#(* % 2)

;; Using anonymous function with map:
(map #(* % 2) [1 2 3])
;; => (2 4 6)

;; == 3. Higher-Order Functions ==

;; map
(map str ["a" "b" "c"] ["1" "2" "3"])
;; => ("a1" "b2" "c3")

;; filter
(filter even? [1 2 3 4])
;; => (2 4)

;; reduce
(reduce + [1 2 3 4])
;; => 10
(reduce * [1 2 3 4])
;; => 24

;; == 4. Recursion with loop/recur ==

(defn countdown [n]
  (loop [i n]
    (when (pos? i)
      (println i)
      (recur (dec i)))))

;; Try:
;; (countdown 5)

;; Mini-Quest: the power function

(defn power [base exp]
  (loop [acc 1
         e exp]
    (if (zero? e)
      acc
      (recur (* acc base) (dec e)))))

;; Try:
;; (power 2 5) ; => 32

"Level 3 complete!"
