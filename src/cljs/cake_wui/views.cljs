;;;; -------------------------------------------------------------------------
;;;;
;;;;      _/_/_/    _/_/    _/    _/  _/_/_/_/
;;;;   _/        _/    _/  _/  _/    _/
;;;;  _/        _/_/_/_/  _/_/      _/_/_/
;;;; _/        _/    _/  _/  _/    _/
;;;;  _/_/_/  _/    _/  _/    _/  _/_/_/_/
;;;;
;;;; Cake WUI re-frame domino 5: view functions
;;;;
;;;; @copyright 2020 Dennis Drown and Ostrich Ideas
;;;; -------------------------------------------------------------------------
(ns cake-wui.views
  (:require
   [re-frame.core :as rf]
   [cake-wui.subs :as subs]))


;;; --------------------------------------------------------------------------
(defn main-panel []
  (let [name (rf/subscribe [::subs/name])]
    [:div
     [:h1 "Let's eat " @name]]))
