(ns my.compile
  (:require [sc.api]
            [cljs.build.api :as api]))

(comment
  (require 'cljs.closure :reload-all)
  (require 'cljs.analyzer :reload-all)
  (api/build
    {:main       'my.project.baz
     ;:output-dir "prod-target"
     ;:output-to     "firebase/public/cljs-out/main.js"
     })
  
  (require 'my.project.foo)
  ;#foo/bar"123"
  
  )
