(defproject clojure-cli "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.3.1"]
                 [clojurewerkz/cassaforte "1.3.0-beta12"]
                 [org.apache.cassandra/cassandra-all "2.0.2" :scope "test"]
                 [org.clojure/tools.logging "0.2.6"]]
  :main clojure-cli.bootstrap)
