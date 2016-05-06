(defproject spark-excel "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-excel "0.0.1"]
                 ]
  :profiles {:uberjar {:aot :all}}
  :main clojure.main
  :local-repo "repo"
  )
