(ns advent-of-code.lesson2-test
  (:require [clojure.test :refer :all]
            [advent-of-code.lesson2 :as l2]
            [clojure.string :as str]))


(deftest test-checksum
  (is (= 18 (l2/checksum l2/min-max-diff
                         [[5 1 9 5]
                          [7 5 3]
                          [2 4 6 8]]))))

(deftest test-checksum-div
  (is (= 9 (l2/checksum l2/evenly-divider
                         [[5 9 2 8]
                          [9 4 7 3]
                          [3 8 6 5]]))))


(deftest read-matrix-test
  (is (= [[11 2 3] [1 2]] (l2/read-matrix "11\t2\t3\n1\t2"))))

(deftest permutations-test
  (is (= [[1 2] [1 3] [2 3]] (l2/permutations [1 2 3])))
  )
