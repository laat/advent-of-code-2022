(ns day4
  (:require [clojure.string :as str]))

(defn parse-int [s] (Integer/valueOf s))

(->>
 (slurp "day4.input.txt")
 (str/split-lines)
 (map #(re-seq #"(\d+)-(\d+),(\d+)-(\d+)" %))
 (map #(apply rest %))
 (map #(map parse-int %))
 (filter #(let [[a b x y] %]
            (or (<= a x y b)
                (<= x a b y))))
 (count))
;; => 576

(->>
 (slurp "day4.input.txt")
 (str/split-lines)
 (map #(re-seq #"(\d+)-(\d+),(\d+)-(\d+)" %))
 (map #(apply rest %))
 (map #(map parse-int %))
 (remove #(let [[a b x y] %]
            (or (< b x) (< y a))))
 (count))
;; => 905
