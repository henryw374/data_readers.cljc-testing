(ns my.project.foo)


(def stack (atom nil))

(defn bar [x]
  ;(reset! stack (Exception. ""))
  "clojure!??")

(defn baz [x]
  "baz!!")

; clj --main cljs.main -e "(println #foo/bar \"world\")"
; https://ask.clojure.org/index.php/9957/behaviour-of-datareaders-cljc
; prove there is no way to have separate behaviour for clj vs cljs
;cljs.user=> (my.project.foo/bar "sdf")
;"sdfclojurescript"
;cljs.user=> #foo/bar"123"
;"123clojure"

(comment
  ; clj --main cljs.main -re node
  ; (require 'clojure.tools.reader)
  ;(clojure.tools.reader/read-string "#foo/bar\"123\"")
  
  
  (require 'cljs.closure)
  ;#foo/bar"123"
  (set! *data-readers* {})
  (get @cljs.env/*compiler* :cljs.analyzer/data-readers)
  (cljs.closure/get-data-readers*)
  (clojure.tools.reader/*data-readers*)
  (clojure.tools.reader/read-string
    {:eof nil :read-cond :allow :features #{:cljs}} 
    "{foo/bar #?(:clj my.project.foo/bar :cljs my.project.foo/baz)}"
    ;"[#?(:clj my.project.foo/bar :cljs my.project.foo/baz)]"
    )
  
  
  )

