(ns cljs-showoff.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [:body {:color "black"
          :font-family "'Archivo'"
          :font-size "1em"
          :line-height "1.6"}]
  [:a {:color "#1565c0"}]
)
