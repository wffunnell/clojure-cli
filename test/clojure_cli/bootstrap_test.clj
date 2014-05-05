(ns clojure-cli.cass_tools_test
  (:require [clojure.test :refer :all]
            [clojure-cli.cass-tools :as app]
            [clojurewerkz.cassaforte.embedded :as cass]
            [clojurewerkz.cassaforte.client :as client]))

(defn spin-cassandra []
  (cass/start-server! :cleanup true))

;(client/connect! ["127.0.0.1"])

(defn kill-cassandra []
  (cass/stop-server!))

(use-fixtures :once
              (fn [your-tests]
                (spin-cassandra)
                (your-tests)
                (kill-cassandra)))

;(deftest bootstrap-with-no-args
;  (testing "run application with no arguments displays help section"
;    (is (= 1 1))))


