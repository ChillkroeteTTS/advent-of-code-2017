(ns advent-of-code.lesson1)

(defn ret-if-eq [tuple]
  (if (= (first tuple) (second tuple))
    (first tuple)
    0))

(defn solve-numeric [numbers]
  (let [enh (conj numbers (first numbers))
        part (partition 2 1 enh)]
    (reduce (fn [agg tuple] (+ agg (ret-if-eq tuple))) 0 part)))

(defn find-buddy [long number-length curr-index]
  (let [offset (int (/ number-length 2))]
    (nth long (+ curr-index offset))))

(defn solve-numeric-part2 [numbers]
  (let [long (concat numbers numbers)
        buddys (map-indexed (fn [i n] (find-buddy long (count numbers) i)) numbers)
        enh (partition 2 (interleave numbers buddys))]
    (reduce (fn [agg tuple] (+ agg (ret-if-eq tuple))) 0 enh)))

(defn str-to-seq [mystr]
  (map #(Integer. (re-find #"\d+" (str %))) mystr))