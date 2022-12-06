(ns day1
  (:require [clojure.string :as str]))

(defn parse-int [s] (Integer/valueOf s))

(->>
 (str/split (slurp "day1.input.txt") #"\n\n")
 (map str/split-lines)
 (map #(map parse-int %))
 (map #(reduce + %))
 (apply max))
;; => 69177

(->>
 (str/split (slurp "day1.input.txt") #"\n\n")
 (map str/split-lines)
 (map #(map parse-int %))
 (map #(reduce + %))
 (sort #(compare %2 %1))
 (take 3)
 (reduce +))
;; => 207456
