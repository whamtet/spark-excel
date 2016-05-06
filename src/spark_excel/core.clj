(ns spark-excel.core
  [:use clj-excel.core]
  (:gen-class
    :methods [^:static [spitDataframe [] clojure.lang.IFn]]
    ))

(defn df->array [df]
  (conj
    (map #(-> % .toSeq .array) (.collect df))
    (.columns df)))

(defn spit-df
  "Spark Dataframe to Array"
  [f tabs & dataframes]
  (when (empty? dataframes) (throw (Exception. "Supply Dataframes!")))
  (let [
         tabs (concat tabs (repeatedly gensym))
         sheets (zipmap tabs (map df->array dataframes))
         ]
    (-> (build-workbook (workbook-xssf) sheets) (save f))))

;export function to Java / Scala
(defn -spitDataframe [] spit-df)

