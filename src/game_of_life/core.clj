(ns game-of-life.core
  (require [game-of-life.io :as io]))

(io/visualize (io/read-cells-from "examples/lwss.txt"))
