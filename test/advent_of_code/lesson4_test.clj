(ns advent-of-code.lesson4-test
  (:require [clojure.test :refer :all]
            [advent-of-code.lesson4 :as l4]))

(deftest valid?-test
  (is (= true (l4/valid? "aa bb cc dd ee")))
  (is (= false (l4/valid? "aa bb cc dd aa")))
  (is (= true (l4/valid? "aa bb cc dd aaa"))))

(deftest valid2?-test
  (is (= true (l4/valid2? "abcde fghij")))
  (is (= false (l4/valid2? "abcde xyz ecdab")))
  (is (= true (l4/valid2? "a ab abc abd abf abj")))
  (is (= true (l4/valid2? "iiii oiii ooii oooi oooo")))
  (is (= false (l4/valid2? "lnlxxn nxllnx vhjrev uoew zts smkd kynlrg")))
  (is (= false (l4/valid2? "oiii ioii iioi iii"))))

(deftest permutations-test
  (is (= #{"c"} (l4/permutations "c")))
  (is (= #{"bc" "cb"} (l4/permutations "bc")))
  (is (= #{"abc" "acb" "bac" "bca" "cab" "cba"} (l4/permutations "abc"))))
