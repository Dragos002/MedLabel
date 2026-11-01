# App idea

## The basics

- **App name:** MedLabel
- **One-line pitch:** MedLabel is an offline health utility that parses prescription labels to set up local medication schedules without exposing health data to the cloud.
- **The problem:** Patients and home caregivers need to record dosage details accurately without uploading sensitive personal health information to external servers.
- **Target users:** Patients managing multiple daily prescriptions and caregivers operating in home or low-connectivity settings.

## The prototype scope

Keep this tiny: one or two screens for Lab 3.

- **Core screen(s):** The app features a medication schedule list view and a camera label scanner confirmation view.
- **The main "thing" the app manages:** It manages individual medication entry records.
- **A few fields of that thing:** Medication name, dosage string, administration instructions, next dose timestamp, and sync status flag.

## The data

- **What records does the app create or collect?** The app creates medication schedule entries, prescription label photo captures, and dose administration logs.
- **Where does data come from?** Data originates from the device camera, on-device ML Kit text recognition, and manual user form edits.
- **Where does data need to go?** Data is stored locally in an on-device database, with encrypted backup payloads syncing to a remote server when online.

## Mobile-computing framing (required)

This is what makes it a mobile-computing project rather than just an app. Answer honestly; rough
answers are fine for now.

- **What must persist on the device** (survive a restart)? Active medication schedules, dosage rules, dose logs, and captured label images must persist locally.
- **What crosses the network** (comes from or goes to a server or API)? Encrypted JSON schedule backups push to a remote REST endpoint when internet connectivity is available.
- **What must still work with no signal**, and how should it behave offline? Label scanning, text extraction, schedule viewing, and notification alarms must work 100% offline without degraded functionality.
- **The placement question:**  Label text extraction runs locally using ML Kit OCR rather than sending photos to a cloud vision API. Moving OCR on-device guarantees complete privacy and eliminates network latency, trading off cloud LLM capabilities such as medical shorthand interpretation.

## What comes next

You do not need to plan the rest of the course here. Each upcoming lab takes one part of this app
and makes it real (structure first, then networking, storage, offline behaviour, and so on). You will
sketch that roadmap for your own app in `reflection.md`, once you have built the prototype and seen
first hand where it falls short.