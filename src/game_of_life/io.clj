(ns game-of-life.io
  (require [clojure.string :as str :only [split-lines]]))

(defn- str-to-cell [sym]
  (case sym
    "X" {:alive true :age 0}
    "-" {:alive false :age 0}
    throw (IllegalArgumentException. (str "unknown pattern: " sym))))

(defn- line-to-cells [s]
  (map str-to-cell (re-seq #"\S" s)))

(defn read-cells-from [filename]
  (map line-to-cells (str/split-lines (slurp filename))))
