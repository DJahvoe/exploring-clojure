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

;; LAST PAGE: 43

