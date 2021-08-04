(ns shadow-compile
  (:require [shadow.cljs.devtools.api :as api]
            [shadow.cljs.devtools.server :as server]
            [shadow.cljs.build-report :as build-report]
            [clojure.java.shell :as sh]))

(defn restart []
  (server/stop!)
  (server/start!))

(defn clean [path]
  (sh/sh "rm" "-rf" (str "./shadow/public/" path)))

(defn delete-cache []
  (sh/sh "rm" "-rf" (str "./.shadow-cljs/builds")))

(defn prod-build []
  (clean "shadow")
  (api/release :app))

(comment
  (restart)
  (prod-build)
  

  )

