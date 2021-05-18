(ns my.project.build
  (:require
    [sc.api :as sc]
    [cljs.build.api :as cljs]))
(comment
  (require 'clojure.tools.reader :reload)
  (require 'cljs.build.api :reload-all)
  (do
    (clojure.java.shell/sh "rm" "-rf" "out/my")
    (cljs/build
      {
       :optimizations :whitespace
       ;:pseudo-names true
       :main          'my.project.baz
       :process-shim  false
       :output-to     "resources/public/cljs-out/main.js"}))

  )


