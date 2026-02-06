def superproject_shortsha(d):
    import os
    import subprocess

    # Common layout: superproject contains "poky/" (COREBASE points inside it)
    superproj = os.path.dirname(d.getVar("COREBASE") or "")

    try:
        sha = subprocess.check_output(
            ["git", "rev-parse", "--short", "HEAD"],
            cwd=superproj,
            stderr=subprocess.DEVNULL,
        ).decode("utf-8").strip()
        return sha
    except Exception:
        bb.warn("Could not determine superproject git SHA; using 'unknown'")
        return "unknown"
