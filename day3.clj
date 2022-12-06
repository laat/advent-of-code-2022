(ns day3
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(def prio (zipmap "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
                  (range 1 53)))
(->>
 (slurp "day3.input.txt")
 (str/split-lines)
 (map #(split-at (quot (count %) 2) %))
 (map #(map set %))
 (map #(apply set/intersection %))
 (map first)
 (map prio)
 (reduce +))
;; => 7701


(->>
 (slurp "day3.input.txt")
 (str/split-lines)
 (partition-all 3)
 (map #(map set %))
 (map #(apply set/intersection %))
 (map first)
 (map prio)
 (reduce +))
;; => 2644
