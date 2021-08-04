(ns dot.dot-test)


(defn ^:export dotdot [^js foo]
  (js/console.log "bar? " foo.bar))


(defn ^:export dotdotsash [^js foo]
  (js/console.log "car? " foo.car (.-car foo)))




