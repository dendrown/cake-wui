;;;; We need a foreach-else command in the language
(ns proglang.core
  (:require [clojure.string :as str]))


;;; TESTING VARS
(def something  (str/split "Great power ... great complexity?" #" "))
(def nothing    [])
(def NOTHING!   nil)
(def numbers    (into [] (range 10)))


;;; ---------------------------------------------------------------------------
;;; LANGUAGE ADDITION

(defmacro foreach-else
  "Dave needs a foreach-else construct in his programming languages."
  [[x xs] foreach else]
  (let [xseq (eval xs)]                     ; Only evaluate once
    ;; And Bob's your uncle!
    `(if (not-empty ~xseq)
         (doseq [~x ~xseq]
           ~foreach)
         ~else)))


;;; ---------------------------------------------------------------------------
;;; DOES IT WORK?
(foreach-else [thing something]
  (println thing)
  (println "Can I haz somethin' ta printz?"))

; OUTPUT:
; -------
; Great
; power
; ...
; great
; complexity?


;;; ---------------------------------------------------------------------------
(foreach-else [thing nothing]
  (println thing)
  (println "Can I haz somethin' ta printz?"))

; OUTPUT:
; -------
; Can I haz somethin' ta printz?


;;; ---------------------------------------------------------------------------
;;; Does it work?
(foreach-else [thing NOTHING!]
  (println thing)
  (println "Can I haz somethin' ta printz?"))

; OUTPUT:
; -------
; Can I haz somethin' ta printz?


;;; ---------------------------------------------------------------------------
(foreach-else [x numbers]
  (let [dbl (* x x)]
    (println "Doubled, it's" dbl))
  42)

; OUTPUT:
; -------
; Doubled, it's 0
; Doubled, it's 1
; Doubled, it's 4
; Doubled, it's 9
; Doubled, it's 16
; Doubled, it's 25
; Doubled, it's 36
; Doubled, it's 49
; Doubled, it's 64
; Doubled, it's 81

