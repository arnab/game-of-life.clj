(ns game-of-life.io
  (require [clojure.string :as str :only [join split-lines]]
           [clojure.set :as set :only [map-invert]]))

(def sym-to-state
  {"X" :alive, "-" :dead})

(def state-to-sym
  (set/map-invert sym-to-state))

(defn- str-to-cell
  [sym]
  {:age 0, :state (sym-to-state sym)}
  )

(defn- line-to-cells
  [s]
  (map str-to-cell (re-seq #"\S" s)))

(defn read-cells-from
  [filename]
  "Read cells from a text file. Run as: `(read-cells-from 'examples/lwss.txt')`"
  (map line-to-cells (str/split-lines (slurp filename))))

(defn- cell-to-sym
  [cell]
  (state-to-sym (cell :state)))

(defn- visualize-cells
  [cells]
  (map cell-to-sym cells))

(defn visualize
  ([rows-of-cells]
     (visualize rows-of-cells []))
  ([rows-of-cells acc]
     (if (empty? rows-of-cells)
       acc
       (visualize (rest rows-of-cells)
                  (conj acc
                        (visualize-cells (first rows-of-cells)))))))

(defn display
  [rows-of-cells]
  (str/join "\n"
            (map #(str/join " " %)
                 (visualize rows-of-cells))))
