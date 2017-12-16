(ns advent-of-code.lesson3)

(defn mf [w]
  (int (Math/floor (/ w 2))))

(defn br [w] [(mf w) (- (mf w))])
(defn tr [w] [(mf w) (mf w)])
(defn tl [w] [(- (mf w)) (mf w)])
(defn bl [w] [(- (mf w)) (- (mf w))])
(defn y [coord] (second coord))
(defn x [coord] (first coord))
(defn irange [start end] (range start (inc end)))

(defn swoosh-coords [w]
  (let [s-tr (map #(vector (mf w) %) (irange (inc (y (br w)))
                                             (y (tr w))))
        tr-tl (map #(vector % (mf w)) (reverse (irange (x (tl w))
                                                       (dec (x (tr w))))))
        tl-bl (map #(vector (- (mf w)) %) (reverse (irange (y (bl w))
                                                           (dec (y (tl w))))))
        bl-br (map #(vector % (- (mf w))) (irange (inc (x (bl w)))
                                                  (x (br w))))]
    (concat s-tr tr-tl tl-bl bl-br)))

(defn find-w ([n] (find-w n 1))
  ([n w]
   (if (>= (Math/pow w 2) n)
     w
     (find-w n (+ w 2)))))

(defn last-n [w]
  (Math/pow w 2))

(defn w-range [w]
  (if (= w 1)
    [1]
    (map int (irange (inc (last-n (- w 2))) (last-n w)))))

(defn n-to-swoosh-coord [n]
  (if (= n 1)
    [0 0]
    (let [w (find-w n)
          swoosh-coords (swoosh-coords w)
          offset (- n (last-n (- w 2)))]
      (nth swoosh-coords (dec offset)))))

(defn manhatten-distance [coord1 coord2]
  (+ (Math/abs (- (y coord2) (y coord1))) (Math/abs (- (x coord2) (x coord1)))))

(defn manhatten-n-to-origin [n]
  (let [swoosh-coord (n-to-swoosh-coord n)]
    (prn swoosh-coord)
    (manhatten-distance swoosh-coord [0 0])))


;# --------------------------------------
(defn area [coord]
  (map (fn [[xc yc]] [(+ (x coord) xc) (+ (y coord) yc)]) (swoosh-coords 3)))

(defn take-step [{coord-map :coord-map values :values} coord]
  (let [area (area coord)
        sum (reduce (fn [agg coord] (if-let [v (get coord-map coord)] (+ agg v) agg)) 0 area)]
    {:coord-map (assoc coord-map coord sum)
     :values (conj values sum)}))

(defn first-larger-val ([threshold] (first-larger-val threshold {[0 0] 1} 1))
  ([threshold coord-map ow]
    (let [nw (+ ow 2)
          swoosh-coords (swoosh-coords nw)
          res (reduce take-step {:coord-map coord-map :values []} swoosh-coords)
          higher (first (filter #(> % threshold) (:values res)))]
      (if higher h6igher (first-larger-val threshold (:coord-map res) nw)))))