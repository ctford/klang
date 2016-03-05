(ns klangmeister.test.processing
  (:require [cljs.test :refer-macros [deftest testing is]]
            [klangmeister.processing :as processing]
            [klangmeister.framework :as framework]
            [klangmeister.actions :as action]))

(def ignore! (constantly nil))

(deftest stopping
  (testing
    (is
      (=
       (framework/process (action/->Stop :foo) ignore! {:foo {:looping? true}})
       {:foo {:looping? false}}))
    (is
      (=
       (framework/process (action/->Stop :foo) ignore! {:foo {:looping? false}})
       {:foo {:looping? false}}))))
