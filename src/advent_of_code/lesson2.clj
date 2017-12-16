(ns advent-of-code.lesson2
  (:require [clojure.string :as str]))

(defn find-max-and-min [state new-el]
  {:max (max (:max state) new-el)
   :min (min (:min state) new-el)})

(defn min-max-diff [row]
  (let [first-el (first row)
        init-state {:max first-el :min first-el}
        min-max (reduce find-max-and-min init-state row)]
    (- (:max min-max) (:min min-max))))

(defn permutations
  ([coll]
   (permutations coll []))
  ([coll old-combinations]
   (if (> (count coll) 1)
     (let [first (first coll)
           rest (rest coll)
           combinations (map #(vector first %) rest)]
       (permutations rest (concat old-combinations combinations)))
     old-combinations)))

(defn evenly-divider [row]
  (let [permutations (permutations row)
        rev (map reverse permutations)
        all_perm (concat permutations rev)
        oe (first (filter (fn [[a b]] (= (mod a b) 0)) all_perm))
        _ (prn permutations)]
    (/ (first oe) (second oe))))

(defn checksum [row-res-fn matrix]
  (reduce + (map row-res-fn matrix)))

(defn str-to-int [mystr]
  (Integer. (re-find #"\d+" (str mystr))))

(defn read-matrix [mystr]
  (map (fn [row] (map str-to-int (str/split row #"\t")))
       (str/split mystr #"\n")))