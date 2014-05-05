# clojure-cli

An example bootstrap application with options for cassandra admin application

## Usage

To compile:
lein uberjar

Usage:
java -jar clojure-cli-0.1.0-SNAPSHOT-standalone.jar [options] action

Options:
  -P, --port PORT                80         Cassandra Port number
  -H, --hostname HOST            localhost  Cassandra Remote host
  -m, --max-records MAX-RECORDS  1000       Maximum records to delete from cassandra
  -h, --help

Actions:
  count    Show number of entries with missing images
  delete   Delete entries with missing image data, use with -max ${number_to_be_deleted}


## License

Copyright © 2014 Will Funnell

