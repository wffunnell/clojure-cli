(ns clojure-cli.bootstrap
  (:require [clojure-cli.cass-tools :as tools]
            [clojure.tools.cli :refer [parse-opts]]
            [clojure.string :as string])
  (:import (java.net InetAddress))
  (:gen-class :main true))

(def cli-options
  [["-P" "--port PORT" "Cassandra Port number"
    :default 80
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]
    ["-H" "--hostname HOST" "Cassandra Remote host"
     :default (InetAddress/getByName "localhost")
     :default-desc "localhost"
     :parse-fn #(InetAddress/getByName %)]
    ["-m" "--max-records MAX-RECORDS" "Maximum records to delete from cassandra"
     :default 1000
     :parse-fn #(Integer/parseInt %)
     :validate [#(< % 100000) "Must be less than 100,000"]]
    ["-h" "--help"]])

(defn usage [options-summary]
  (->> ["Help section"
        ""
        "Usage: program-name [options] action"
        ""
        "Options:"
        options-summary
        ""
        "Actions:"
        "  count    Show number of entries with missing images"
        "  delete   Delete entries with missing image data, use with --max-records ${number_to_be_deleted}"
        ""]
       (string/join \newline)))

(defn error-msg [errors]
  (str "The following errors occurred while parsing your command:\n\n"
       (string/join \newline errors)))

(defn exit [status msg]
  (println msg)
  ;(System/exit status)
  (println status)
  )

(defn -main [& args]
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (cond
      (:help options) (exit 0 (usage summary))
      errors (exit 1 (error-msg errors))
      (= (count arguments) 0) (exit 1 (usage summary))
      (= (first arguments) "count") (tools/count-records-without-images)
      (= (first arguments) "delete") (tools/delete-records-without-images (:max-records options)))))
