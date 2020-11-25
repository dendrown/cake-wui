(ns cake-wui.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [cake-wui.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
