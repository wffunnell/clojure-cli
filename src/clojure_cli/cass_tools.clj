(ns clojure-cli.cass-tools)

(defn count-records-without-images []
  (println "Counted records without images"))

(defn delete-records-without-images [max-records]
  (println (str "Deleted " max-records " records")))
