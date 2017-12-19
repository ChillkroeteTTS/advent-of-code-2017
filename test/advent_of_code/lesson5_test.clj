(ns advent-of-code.lesson5-test
  (:require [clojure.test :refer :all]
            [advent-of-code.lesson5 :as l5]))

(deftest step-test
  (is (= {:instructions [1 3 0 1 -3] :pos 0}
         (l5/step {:instructions [0 3 0 1 -3] :pos 0})))
  (is (= {:instructions [2 3 0 1 -3] :pos 1}
         (l5/step {:instructions [1 3 0 1 -3] :pos 0})))
  (is (= {:instructions [1 4 0 1 -3] :pos 4}
         (l5/step {:instructions [1 3 0 1 -3] :pos 1})))
  (is (= {:instructions [1 4 0 1 -2] :pos 1}
         (l5/step {:instructions [1 4 0 1 -3] :pos 4})))
  (is (= {:instructions [1 5 0 1 -2] :pos 5}
         (l5/step {:instructions [1 4 0 1 -2] :pos 1}))))

(deftest step-count-test
  (is (= 5 (l5/step-count [0 3 0 1 -3] 0 l5/step))))

(deftest step2-count-test
  (is (= 10 (l5/step-count [0 3 0 1 -3] 0 l5/step2))))
