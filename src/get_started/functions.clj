(ns get-started.functions)

;; Function declaration
(defn this-is-example-function
  "This is DOCSTRING example"
  [test-parameter]
  (println (str "This is function body: " test-parameter)))

(this-is-example-function "hello")

;; Parameters and Arity
(defn multi-arity
  ([] (println "No parameter"))
  ([a] (println (str "Single parameter: " a)))
  ([a b] (println (str "Two parameter: " a " " b))))
(multi-arity)
(multi-arity "test")
(multi-arity "Hello" "World")

;; Return value (return the last form)
(defn testing-return
  [a]
  (println "Hello")
  (println "Another greetings!")
  (+ a 1))
(testing-return 2)

;; Desctructuring
;; -> Destructure Vector or List: First Element of Collection
(defn first' [[first-element]] first-element)
(first' ["A" "B" "C"])

;; -> Destructure Vector or List: needed Element and use 'rest' params
(defn get-first-two
  [[first-element second-element & the-rest]]
  (str "First: " first-element " and " "Second: " second-element ", and this is the rest: " the-rest))
(get-first-two ["Hello" "World" "This" "Is" "Me"])

;; -> Destructure Maps: access the key
(defn get-coord
  [{lat :lat lng :lng}]
  (println (str "Lat: " lat))
  (println (str "Lng: " lng)))
(get-coord {:lat 123.2 :lng 42.3 :is-important true :name "Random Place"})

(defn get-coord2
  [{:keys [lat lng]}]
  (println (str "Lat: " lat))
  (println (str "Lng: " lng)))
(get-coord2 {:lat 123.2 :lng 42.3 :is-important true :name "Random Place"})

;; Anonymous Functions
(map (fn [n] (* n 2)) [1 2 3 4 5])
(#(* % 3) 8)
(map #(* % 2) [1 2 3 4 5])