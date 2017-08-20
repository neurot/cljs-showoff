(ns cljs-showoff.css
  (:require [garden.def :refer [defstyles]]))

(defstyles screen
  [:body {:color "black"
          :font-family "'Crimson Text'"
          :font-size "1.2em"
          :line-height "1.6"}]
  [:a {:color "#1565c0"}]
  [:h1 {:font-family "'Montserrat Subrayada'"
        :font-size "2em"
        ;; :color "#FF3692"
        }]
  [:h2 {:font-family "'Montserrat Subrayada'"}]
  [:h3 {:font-family "'Montserrat Subrayada'"}]
  [:h4 {:font-family "'Montserrat Subrayada'"}]
  [:h5 {:font-family "'Montserrat Subrayada'"}]
  [:h6 {:font-family "'Montserrat Subrayada'"}]
)
