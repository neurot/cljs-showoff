(ns cljs-showoff.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [:body {:color "black"
          :font-family "'Crimson Text'"
          :font-size "1.2em"
          :line-height "1.6"}]
  [:a {:color "#1565c0"}]
  [:h1 {:font-family "Monofett"
        :font-size "4em"
        :color "#FF3692"}]
  [:h2 {:font-family "Monofett"}]
  [:h3 {:font-family "Monofett"}]
  [:h4 {:font-family "Monofett"}]
  [:h5 {:font-family "Monofett"}]
  [:h6 {:font-family "Monofett"}]
)
