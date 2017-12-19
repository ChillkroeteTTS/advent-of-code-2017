(ns advent-of-code.lesson4
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(defn permutations [a-str]
  (if (= (count a-str) 1)
    #{a-str}
    (reduce (fn [agg [lidx letter]]
              (let [different-letters (keep-indexed (fn [idx _] (when (not= idx lidx) _)) a-str)
                    combinations (into #{} (mapv #(str letter (str/join %)) (permutations different-letters)))]
                (set/union agg combinations)))
            #{}
            (map-indexed vector a-str))))

(defn valid? [passphrase]
  (let [words (str/split passphrase #"\s+")]
    (= (count words) (count (into #{} words)))))

(defn valid2? [passphrase]
  (let [mypermutations (mapv permutations (str/split passphrase #"[\s\t]+"))
        perm-count (reduce #(+ %1 (count %2)) 0 mypermutations)
        unified (reduce set/union mypermutations)]
    (= perm-count (count unified))))

(defn count-fn [passphrases fn]
  (count (filter fn passphrases)))

(defn read-passphrase-str [passphrase-str]
  (str/split-lines passphrase-str))



