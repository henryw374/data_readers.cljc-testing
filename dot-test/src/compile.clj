(ns compile
  (:require [cljs.build.api :as cljs]))


(def debug-opts 
  {:pseudo-names true
   :pretty-print true})

(defn build []
  (cljs/build
    (->
      {:optimizations :advanced
       :infer-externs true
       :main          'dot.dot-test
       :process-shim  false
       :output-dir    "prod-target"
       :output-to     "prod-target/main.js"}
      ;(merge debug-opts)
      )))

(comment
  (build)
  )
