(ns get-started.control-flow)

;; if
(if true "A" "B")
(if false "A" "B")

(if true "A")
(if false "A")

;; do -> wrap up multiple forms in parentheses and run each of them
(if true 
  (do (println "This is True!")
      "Return This Value if True")
  (do (println "This is False!")
      "Return This Value if False"))

;; when -> combination of if and do, no else branch
(when true 
  (println "Print if True")
  "return True value")

;; truthy falsy

;; OR return first truthy value
(or false nil :hello :world)

;; AND return first
(and :who-are-you :not-this)