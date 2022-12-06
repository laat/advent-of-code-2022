(ns day2
  (:require [clojure.string :as str]))

(def oponent {"A" :R "B" :P "C" :S})
(def me {"X" :R "Y" :P "Z" :S})
(def scores {:R 1 :P 2 :S 3})

(->>
 (slurp "day2.input.txt")
 (str/split-lines)
 (map #(str/split % #" "))
 (map #(list (oponent (first %)) (me (second %))))
 (map #(+ (scores (second %))
          (case %
            [:R :P] 6
            [:P :S] 6
            [:S :R] 6
            [:R :R] 3
            [:P :P] 3
            [:S :S] 3
            0)))
 (apply +))
;; => 11841


(def win {:R :P :P :S :S :R})

(->>
 (slurp "day2.input.txt")
 (str/split-lines)
 (map #(str/split % #" "))
 (map #(list (oponent (first %)) (second %)))
 (map #(list (first %)
             (cond
               (= (second %) "Y") (first %)
               (= (second %) "X") (win (win (first %)))
               :else (win (first %)))))
 (map #(+ (scores (second %))
          (case %
            [:R :P] 6
            [:P :S] 6
            [:S :R] 6
            [:R :R] 3
            [:P :P] 3
            [:S :S] 3
            0)))
 (apply +))
;; => 13022
