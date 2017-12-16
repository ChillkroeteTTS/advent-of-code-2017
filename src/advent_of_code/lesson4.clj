(ns advent-of-code.lesson4
  (:require [clojure.string :as str]))

(defn valid? [passphrase]
  (let [splitted (str/split passphrase #"\s")
        count_splitted (count splitted)]
    (= count_splitted (count (into #{} splitted)))))

(defn count-valid [passphrases]
  (count (filter valid? passphrases)))

(defn read-passphrase-str [passphrase-str]
  (str/split-lines passphrase-str))


(defn permutations [a-str]
  (if (= (count a-str) 1)
    [a-str]
    (reduce (fn [agg letter]
              (let [different-letters (map str (filter #(not= letter %) a-str))
                    combinations (mapv #(str letter (str/join %)) (permutations different-letters))]
                (concat agg combinations)))
            []
            a-str)))


