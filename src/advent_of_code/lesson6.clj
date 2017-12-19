(ns advent-of-code.lesson6)

(defn first-max [[min-idx min-block] [idx block]]
  (if (> block min-block) [idx block] [min-idx min-block]))

(defn safe-idx [idx list]
  (mod idx (count list)))

(defn inc-from [list idx cnt]
  (if (> cnt 0)
    (inc-from (update list idx inc) (safe-idx (inc idx) list) (dec cnt))
    list))

(defn redistribute [blocks]
  (let [indexed (into [] (map-indexed vector blocks))
        [min-idx min-val] (reduce first-max indexed)
        new-blocks (assoc (mapv second indexed) min-idx 0)]
    (inc-from new-blocks (safe-idx (inc min-idx) indexed) min-val)))

(defn redistribute-until [blocks]
  (let [seen (atom #{})]
    (loop [seen #{}
           seen-id {}
           blocks blocks
           cnt 0]
      (if (contains? seen blocks)
        {:cnt cnt :loop (- cnt (get seen-id blocks))}
        (recur (conj seen blocks)
               (assoc seen-id blocks cnt)
               (redistribute blocks)
               (inc cnt))))))