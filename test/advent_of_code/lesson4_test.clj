(ns advent-of-code.lesson4-test
  (:require [clojure.test :refer :all]
            [advent-of-code.lesson4 :as l4]))

(deftest valid?-test
  (is (= true (l4/valid? "aa bb cc dd ee")))
  (is (= false (l4/valid? "aa bb cc dd aa")))
  (is (= true (l4/valid? "aa bb cc dd aaa"))))

(deftest permutations-test
  (is (= ["c"] (l4/permutations "c")))
  (is (= ["bc" "cb"] (l4/permutations "bc")))
  (is (= ["abc" "acb" "bac" "bca" "cab" "cba"] (l4/permutations "abc"))))
