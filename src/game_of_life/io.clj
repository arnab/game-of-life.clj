(ns game-of-life.io
  (require [clojure.string :as str :only [split-lines]]))

(defn- sym-to-cell-state
  [sym]
  (case sym
    "X" true
    "-" false
    throw (IllegalArgumentException. (str "unknown pattern: " sym))))

(defn- str-to-cell
  [sym]
  {:age 0, :alive (sym-to-cell-state sym)}
  )

(defn- line-to-cells
  [s]
  (map str-to-cell (re-seq #"\S" s)))

(defn read-cells-from
  [filename]
  "Read cells from a text file. Run as: `(read-cells-from 'examples/lwss.txt')`"
  (map line-to-cells (str/split-lines (slurp filename))))

(defn display-board
  [cells]
  )
