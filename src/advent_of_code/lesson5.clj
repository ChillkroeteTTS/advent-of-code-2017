(ns advent-of-code.lesson5)


(defn step [{instructions :instructions pos :pos}]
  {:instructions (update instructions pos inc)
   :pos (+ pos (nth instructions pos))})

(defn step2 [{instructions :instructions pos :pos}]
  {:instructions (update instructions pos #(if (>= % 3) (dec %) (inc %)))
   :pos          (+ pos (nth instructions pos))})

(defn step-count [instructions pos step]
  (loop [instr+pos {:instructions instructions :pos pos}
         cnt 0]
    (if (and (>= (:pos instr+pos) 0) (< (:pos instr+pos) (count (:instructions instr+pos))))
      (recur (step instr+pos)
             (inc cnt))
      cnt)))