(ns advent-of-code.lesson3-test
  (:require [clojure.test :refer :all]
            [advent-of-code.lesson3 :as l3]))

(deftest find-w-test
  (is (= 3 (l3/find-w 4)))
  (is (= 1 (l3/find-w 1)))
  (is (= 3 (l3/find-w 9)))
  (is (= 5 (l3/find-w 10))))

(deftest w-range-test
  (is (= [2 3 4 5 6 7 8 9] (l3/w-range 3)))
  (is (= [1] (l3/w-range 1))))

(deftest max-floor-test
  (is (= 1 (l3/mf 3)))
  (is (= 2 (l3/mf 5)))
  (is (= 3 (l3/mf 7))))

(deftest swoosh-adds
  (is (= [[1 0] [1 1] [0 1] [-1 1] [-1 0] [-1 -1] [0 -1] [1 -1]]
         (l3/swoosh-coords 3)))
  (is (= [[2 -1] [2 0] [2 1] [2 2] [1 2] [0 2] [-1 2] [-2 2] [-2 1] [-2 0] [-2 -1] [-2 -2] [-1 -2] [0 -2] [1 -2] [2 -2]]
         (l3/swoosh-coords 5))))

(deftest n-to-swoosh-coord-test
  (is (= [1 -1] (l3/n-to-swoosh-coord 9)))
  (is (= [0 0] (l3/n-to-swoosh-coord 1)))
  (is (= [-1 1] (l3/n-to-swoosh-coord 5)))
  (is (= [-1 -1] (l3/n-to-swoosh-coord 7)))
  (is (= [1 1] (l3/n-to-swoosh-coord 3)))
  (is (= [0 1] (l3/n-to-swoosh-coord 4)))
  (is (= [2 1] (l3/n-to-swoosh-coord 12)))
  )

(deftest manhatten-n-to-origin-test
  (is (= 0 (l3/manhatten-n-to-origin 1)))
  (is (= 3 (l3/manhatten-n-to-origin 12)))
  (is (= 2 (l3/manhatten-n-to-origin 23)))
  (is (= 31 (l3/manhatten-n-to-origin 1024))))

(deftest area-test
  (is (= [[6 5] [6 6] [5 6] [4 6] [4 5] [4 4] [5 4] [6 4]] (l3/area [5 5]))))

(deftest take-step-test
  (is (= {:coord-map {[0 0] 1 [1 0] 2 [1 1] 3} :values [1 2 3]}
         (l3/take-step {:coord-map {[0 0] 1 [1 0] 2} :values [1 2]} [1 1]))))

(deftest first-larger-val-test
  (is (= 10 (l3/first-larger-val 5)))
  (is (= 351 (l3/first-larger-val 330)))
  )