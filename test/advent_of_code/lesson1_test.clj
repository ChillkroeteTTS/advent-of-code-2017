(ns advent-of-code.lesson1-test
  (:require [clojure.test :refer :all]
            [advent-of-code.lesson1 :as l1]))


(deftest name
  (is (= 4 (l1/solve-numeric [1 1 1 1])))
  (is (= 3 (l1/solve-numeric [1 1 2 2])))
  (is (= 0 (l1/solve-numeric [1 2 3 4])))
  (is (= 9 (l1/solve-numeric [9 1 2 1 2 1 2 9])))
  )

(deftest find-buddy-test
  (let [long [1 2 3 4 1 2 3 4]]
    (is (= 3 (l1/find-buddy long 4 0)))
    (is (= 4 (l1/find-buddy long 4 1)))
    (is (= 1 (l1/find-buddy long 4 2)))
    (is (= 2 (l1/find-buddy long 4 3)))))

(deftest name2
  (is (= 6 (l1/solve-numeric-part2 [1 2 1 2])))
  (is (= 0 (l1/solve-numeric-part2 [1 2 2 1])))
  (is (= 12 (l1/solve-numeric-part2 [1 2 3 1 2 3])))
  (is (= 4 (l1/solve-numeric-part2 [1 2 1 3 1 4 1 5])))
  )

(deftest str-to-seq-test
  (is (= [1 2 3 4] (l1/str-to-seq "1234")))
  )