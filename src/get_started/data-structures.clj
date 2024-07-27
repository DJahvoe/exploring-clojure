(ns get-started.data-structures)

;; Numbers
12
1.2
1/2

;; Strings
"The Observable Universe"
(def planet "Earth")
(str planet " is insignificant compare to our Universe")

;; Maps (similar to Object)

;; Maps -> Declaration
{}
{:first-name "Sav"
 :last-name "Awesome"}
{:name {:first "Sav" :middle "Awesome" :last "The Great"}}
(hash-map :a 1 :b 2)

;; Maps -> Accessing Map
(get {:a 0 :b 1} :b)
(get {:a 0 :b 1} :c "Not Found Default Value")
(get-in {:a 0 :b {:c "hmm"}} [:b :c])

;; Maps -> Accessing Map Shorthand (Same Result)
({:phrase "Get Over Here!"} :phrase)
(:phrase {:phrase "Get Over Here!"})

;; Keywords
:a
:42

(:d {:a 1 :b 2 :c 3} "This is Not Found Value")

;; Vectors (similar to Array)
[3 2 1]
(get [3 2 1] 0)
(get ["a" 42 {:message "Hello World!"}] 2)

;; similar to Push
(conj [1 2 3] 4)

;; Lists (similar to Vector but can't retrive elements with 'get')
'(1 2 3 4)
;; similar to get, but 'get' is faster than 'nth'
(nth '(:a :b :c) 0)
;; conj added to head instead of tail like Vectors does
(conj '(1 2 3) 4)

;; Adding items to beginning of sequence? Writing macro? use list, otherwise vector

;; Sets
#{"test" 1 2}
(hash-set 1 1 2 2 3 3)
(sorted-set 3 3 2 1 2 3 1 2 3)
(conj #{:a :b} :b)
(set [3 3 3 4 4])
(contains? #{:a :b} :a)
(:a #{:a :b})
(:c #{:a :b})
