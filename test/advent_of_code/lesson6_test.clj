(ns advent-of-code.lesson6-test
  (:require [clojure.test :refer :all]
            [advent-of-code.lesson6 :as l6]))


(deftest inc-from-test
  (is (= [2 3 4] (l6/inc-from [1 2 3] 1 3)))
  )

(deftest redistribute-test
  (is (= [2 4 1 2] (l6/redistribute [0 2 7 0])))
  (is (= [3 1 2 3] (l6/redistribute [2 4 1 2])))
  (is (= [0 2 3 4] (l6/redistribute [3 1 2 3])))
  (is (= [1 3 4 1] (l6/redistribute [0 2 3 4])))
  (is (= [2 4 1 2] (l6/redistribute [1 3 4 1]))))

(deftest redistribute-until-test
  (is (= {:cnt 5 :loop 4} (l6/redistribute-until [0 2 7 0]))))