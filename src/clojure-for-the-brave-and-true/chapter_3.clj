;; -------FORM-------
1
"a string"
["hello" "world"]

;; (operator operand1 operand2 ... operandn)
(+ 1 2 3)
; => 6

;; -------CONTROL FLOW-------
;; (if boolean-form then-form optional-else-form) 
(if true "i am handsome" "i am mid")
; => "i am handsome"
(if false "i am handsome" "i am mid")
; => "i am mid"
(if false "hello")
; => nil

;; do
;; wrap up multiple forms in parentheses and run each
(if true
  (do (print "execute 1") "execute 2")
  (do (print "false 1") "false 2"))

;; when
;; when operator is like a combination of if and do, but with no else branch
(when true
  (print "Hello")
  "return world")

;; nil, true, false, Truthiness, Equality, and Boolean Expressions
(nil? 1)
(nil? nil)
(if "string true" "hello")
(if nil "true" "falsey")
(= 1 1)

;; and, or
;; OR: 
(or false nil "hello")

;; AND: choose last truthy value 
(and :free_wife :hot_coffee)
(and :feeling_super_cool nil false)

;; Naming Values with def
(def first-name "Sav")
first-name

;; imperative programming way
(def age 15)
(def error-message "RESULT: ")
(if (>= age 20)
  (def error-message (str error-message "You're ALLOWED to enter"))
  (def error-message (str error-message "You're NOT ALLOWED to enter")))
error-message

;; Clojure way
;; Function with defn
(defn error-message
  [age]
  (str "RESULT: "
       (if (>= age 20)
         "You're ALLOWED to enter"
         "You're NOT ALLOWED to enter")))

(error-message 20)

;; Data Structures
; Numbers
93
1.2
1/5

; Strings
"Hello"
"World"
"\"It's Me! Mario!\""

; Maps
{}
{:first-name "Sav"
 :last-name "Test"}
{"string-key" +}
{:name {:first "Sav"
        :last "Test"}}

(def test-map (hash-map
               :a 1
               :b 2))
(get test-map :b)
(get test-map :c "Not Found")

; Nested Map
(def nested-map {:a 0
                 :b {:c "hello world"}})
(get-in nested-map [:b :c])

; Keywords -> usually used as keys in maps
; Equivalent for get
(def test-keywords {:a 1 :b 2 :c 3})
(:a test-keywords)
(get test-keywords :a)

(:d test-keywords "Not Found default")
(get test-keywords :d "Not Found default")

; Vector -> similar to array, each element can be assigned to any element
(def test-vector [3 2 1])
(get test-vector 0)

; Vector created by function
(def test-vector-fn (vector "this" "is" "an" "apple"))
; conj to add element to the end of vector
(conj test-vector-fn "hello")

; Lists -> similar to vectors, but can't retrive list elements with get
'(1 2 3 4)
; nth function
(def test-list '("hello" "world" "name's" "Sav"))
(nth test-list 3)

; list function
(def test-list-fn (list 1 "two" {3, 4}))
; conj add the beginning of list
(conj test-list-fn 4)

; When to use List, and When should we use Vector?
; Rule of thumb: 
; add items to the beginning of a sequence, OR writing a macro -> use List
; Otherwise -> Vector

; Sets -> hash-set and sorted-set, for storing unique value
; hash-set
#{"1" 2 3}
(hash-set 1 1 2 2)
(conj #{:a :b} :b)
(set [3 3 3 4 4])

(contains? #{:a :b} :a)

;; LAST PAGE: 48

