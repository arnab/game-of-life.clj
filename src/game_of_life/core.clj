(ns game-of-life.core
  (require [game-of-life.io :as io])
  (:gen-class :main true))

#_ (io/read-cells-from "examples/lwss.txt")
#_ (io/visualize (io/read-cells-from "examples/lwss.txt"))
#_(print (io/display (io/read-cells-from "examples/lwss.txt")))

(defn -main
  [& args]
  (print (io/display (io/read-cells-from "examples/lwss.txt"))))
